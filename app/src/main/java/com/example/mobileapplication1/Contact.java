package com.example.mobileapplication1;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String name;
    private String ownerLoginName;

    public Contact(String name, String ownerLoginName, String nodeId, String description, String fork, String downloadUrl) {
        this.name = name;
        this.ownerLoginName = ownerLoginName;
        this.nodeId = nodeId;
        this.description = description;
        this.fork = fork;
        this.downloadUrl = downloadUrl;
    }

    private  String nodeId;
    private  String description;
    private  String fork;
    private  String downloadUrl;

    protected Contact(Parcel in) {
        name = in.readString();
        ownerLoginName = in.readString();
        nodeId = in.readString();
        description = in.readString();
        fork = in.readString();
        downloadUrl = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLoginName() {
        return ownerLoginName;
    }

    public void setOwnerLoginName(String ownerLoginName) {
        this.ownerLoginName = ownerLoginName;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(ownerLoginName);
        dest.writeString(nodeId);
        dest.writeString(description);
        dest.writeString(fork);
        dest.writeString(downloadUrl);
    }
}
