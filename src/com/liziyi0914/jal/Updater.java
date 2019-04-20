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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liziyi0914
 */
public class Updater {

    App app;
    static Gson gson = new Gson();

    public void checkUpdate() {
        System.out.println("com.lzy2002.launcher.Updater.checkUpdate()");
        try {
            Resource res = dlResource(app.Link());
            if (res.getVersionID() > app.VersionID()) {
                System.err.println("update!!!");
                update(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Resource res) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    dlMain(res);
                    File updateFlag = new File(".\\_UPDATE");
                    updateFlag.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    public Updater(App app) {
        this.app = app;
    }

    public static Resource dlResource(String link) {
        try {
            byte[] data = Downloader.downLoadFromURL(link);
            if (data == null) {
                return null;
            }
            String j = new String(data);
            Resource res = gson.fromJson(new String(data), Resource.class);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static File dlMain(Resource res) {
        try {
            byte[] jarsFile = Downloader.downLoadFromURL(res.getLink());
            File dlFile = new File(".\\download.temp");
            if (dlFile.exists()) {
                dlFile.delete();
            }
            FileOutputStream out = new FileOutputStream(dlFile);
            out.write(jarsFile);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void runUpdate() {
        File updateFlag = new File(".\\_UPDATE");
        if (updateFlag.exists()) {
            Date d = new Date();
            File old = new File(".\\packet.jars");
            old.renameTo(new File(".\\" + d.getTime() + ".old"));
            File dlFile = new File(".\\download.temp");
            dlFile.renameTo(new File(".\\packet.jars"));
            updateFlag.delete();
        }
    }

    public static void runInstall(String link) {
        dlMain(dlResource(link));
        File dl = new File(".\\download.temp");
        File packet = new File(".\\packet.jars");
        try {
            Files.move(dl.toPath(), packet.toPath());
        } catch (IOException ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
