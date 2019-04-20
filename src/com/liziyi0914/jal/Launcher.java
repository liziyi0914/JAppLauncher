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
import com.liziyi0914.scl.jars.JARSFile;
import com.liziyi0914.scl.SecurityClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 *
 * @author liziyi0914
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, FileNotFoundException, IOException, Exception {
//        Updater.runUpdate();
        File packet = new File("packet.jars");
        if (!packet.exists()) {
            File resF = new File("resource.json");
            Resource res = new Gson().fromJson(new FileReader(resF), Resource.class);
            Updater.runInstall(res.getJsonLink());
        }
        JARSFile jarsf = JARSFile.load(packet);
        SecurityClassLoader loader = new SecurityClassLoader(jarsf);
        Launcher launcher = new Launcher();
        Class c = loader.loadClass(jarsf.getLaunchClass());
        App app = (App) c.getAnnotation(App.class);
        Method m = c.getMethod("launch", ApplicationContext.class);
        ApplicationContext context = new ApplicationContext(launcher,new Updater(app), args);
        m.invoke(c.newInstance(), context);
    }

}
