package com.example.partyplanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;




public class PartyContentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.partyplanner";
    public static final String PATH = "party";

    public static final int ALL_PARTY = 1;
    public static final int PARTY = 2;


    private PartyData partyDataBase = null;
    private DBHelper dbHelper = null;

    private UriMatcher uriMatcher = null;


    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        partyDataBase = new PartyData(getContext());

        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PATH, ALL_PARTY);
        uriMatcher.addURI(AUTHORITY, PATH + "/#", PARTY);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case ALL_PARTY:
                return "vnd.android.cursor.dir/guests";
            case PARTY:
                return "vnd.android.cursor.item/guest";
            default:
                throw new UnsupportedOperationException("Unknown URI : " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        switch (uriMatcher.match(uri)) {
            case ALL_PARTY:
                long insertID = dbHelper.addItem(new PartyData(values));
                getContext().getContentResolver().notifyChange(uri, null);
                return uri;

            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported");
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case ALL_PARTY:
                String partyID = uri.getLastPathSegment();
                count = dbHelper.deleteItem(Integer.parseInt(partyID));
                getContext().getContentResolver().notifyChange(uri, null);
                return count;
            case PARTY:
                count = dbHelper.deleteItem(selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                return count;
            default:
                throw new UnsupportedOperationException("Unknown URI : " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case ALL_PARTY:
                String partyID = uri.getLastPathSegment();
                PartyData theParty = new PartyData(values);
                theParty.setId(Integer.getInteger(partyID));
                count = dbHelper.updateItem(theParty);
                getContext().getContentResolver().notifyChange(uri, null);
                return count;
            case PARTY:
                count = dbHelper.updateItem(values, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                return count;
            default:
                throw new UnsupportedOperationException("Unknown URI : " + uri);
        }
    }
}
