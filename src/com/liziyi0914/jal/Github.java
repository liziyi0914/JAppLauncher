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

import com.google.gson.Gson;

/**
 *
 * @author liziyi0914
 */
public class Github {
    
    public static String getFile(String repo,String name) throws Exception{
        Gson gson = new Gson();
        String json = new String(Downloader.downLoadFromURL("https://api.github.com/repos/"+repo+"/releases"));
        GithubRepoRelease[] rs = gson.fromJson(json,GithubRepoRelease[].class);
        if (rs.length==0) {
            throw new Exception();
        }
        String version = rs[0].getTag_name();
        System.out.println("https://github.com/"+repo+"/releases/download/"+version+"/"+name);
        return "https://github.com/"+repo+"/releases/download/"+version+"/"+name;
    }
    
}

class GithubRepoRelease {

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    private String tag_name;
    private String url;

    /**
     * @return the tag_name
     */
    public String getTag_name() {
        return tag_name;
    }

    /**
     * @param tag_name the tag_name to set
     */
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
