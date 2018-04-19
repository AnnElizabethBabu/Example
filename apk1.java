bdsourcesync = apkpath;
            progress.setString("sync in progress");
            System.out.println("Starting Sync via adb with command " + "adb"
                    + " install -r " + apkpath);

            ProcessBuilder apksync = new ProcessBuilder("adb",  " install -r ",  apkpath);

            apksync = apksync.redirectErrorStream(true);
/*          Process process = Runtime.getRuntime().exec(
                    "adb" + " install -r " + apkpath);*/
            Process process = apksync.start();
            InputStreamReader reader = new InputStreamReader(
                    process.getInputStream());
            Scanner scanner = new Scanner(reader);
            scanner.close();
            int exitCode = process.waitFor();
            System.out.println("Process returned: " + exitCode);
