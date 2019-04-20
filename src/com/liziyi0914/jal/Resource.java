/*
 * Copyright 2019 liziyi0914.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liziyi0914.jal;

/**
 *
 * @author liziyi0914
 */
public class Resource {

    private String AppName = "App";
    private String PackageName = "com.example.app";
    private int VersionID = 0;
    private String Version = "0.0.1";
    private String Author = "Dev";
    private String Git = "";
    private String Link = "";
    private String JsonLink = "";
    private String[] Require = new String[1];

    /**
     * @return the AppName
     */
    public String getAppName() {
        return AppName;
    }

    /**
     * @param AppName the AppName to set
     */
    public void setAppName(String AppName) {
        this.AppName = AppName;
    }

    /**
     * @return the PackageName
     */
    public String getPackageName() {
        return PackageName;
    }

    /**
     * @param PackageName the PackageName to set
     */
    public void setPackageName(String PackageName) {
        this.PackageName = PackageName;
    }

    /**
     * @return the VersionID
     */
    public int getVersionID() {
        return VersionID;
    }

    /**
     * @param VersionID the VersionID to set
     */
    public void setVersionID(int VersionID) {
        this.VersionID = VersionID;
    }

    /**
     * @return the Version
     */
    public String getVersion() {
        return Version;
    }

    /**
     * @param Version the Version to set
     */
    public void setVersion(String Version) {
        this.Version = Version;
    }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the Git
     */
    public String getGit() {
        return Git;
    }

    /**
     * @param Git the Git to set
     */
    public void setGit(String Git) {
        this.Git = Git;
    }

    /**
     * @return the Link
     */
    public String getLink() {
        return Link;
    }

    /**
     * @param Link the Link to set
     */
    public void setLink(String Link) {
        this.Link = Link;
    }

    /**
     * @return the JsonLink
     */
    public String getJsonLink() {
        return JsonLink;
    }

    /**
     * @param JsonLink the JsonLink to set
     */
    public void setJsonLink(String JsonLink) {
        this.JsonLink = JsonLink;
    }

    /**
     * @return the Require
     */
    public String[] getRequire() {
        return Require;
    }

    /**
     * @param Require the Require to set
     */
    public void setRequire(String[] Require) {
        this.Require = Require;
    }
}
