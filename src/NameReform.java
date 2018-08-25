import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Created by Matin Afkhami on 29/6/18.
 */

class NameReform {

    private int totalFiles=0, filesToRename=0, fileIndex=-1;
    private String[][] log;
    private String regex;
    private String replacementRegex;
    private File directory;

    NameReform(String regex, String replacementRegex, File directory) throws IOException {
        if (regex == null || replacementRegex == null || directory == null){
            throw new IOException("Inputs must not be null.");
        }
        if (!directory.exists()){
            throw new IOException("Directory not exists");
        }
        if (regex.compareTo("") == 0 || replacementRegex.compareTo("") == 0){
            throw new IOException("Inputs must not be empty.");
        }

        this.regex = regex;
        this.replacementRegex = replacementRegex;
        this.directory = directory;

        filesCounter(directory);
    }

    int getFilesToRename(){
        return this.filesToRename;
    }

    int getTotalFiles(){
        return this.totalFiles;
    }

    String getCurrentPath(){
        if (log==null || this.log.length==0){
            return this.directory.getPath();
        }else if (new File(log[0][0]).getPath().compareTo(this.directory.getPath())==0){
            return log[0][1];
        }
        return this.directory.getPath();
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void reformNames() throws Exception {
        log = new String[filesToRename][2];
        fileIndex = -1;
        exploreDirectory(directory);
    }

    private void exploreDirectory(File file) throws Exception {
        if (file.isDirectory()) {
            for (File eachFile : Objects.requireNonNull(file.listFiles())) {
                exploreDirectory(eachFile);
            }
        }
        if (file.getName().matches(regex))
            reform(file);
    }

    private void reform(File file) throws Exception {
        Matcher mtr = Pattern.compile(regex).matcher(file.getName());
        if (mtr.find()){
            int groupCount = mtr.groupCount();
            String[] group = new String[groupCount+1];
            for (int i=0; i<=groupCount; i++){
                if (mtr.group(i)!=null){
                    group[i] = mtr.group(i);
                }else {
                    group[i] = "";
                }
            }
            String newName = replacementRegex;
            for (int i=0; i<=groupCount; i++){
                if (newName.contains("*"+i+"*")){
                    newName = newName.replace("*"+i+"*",group[i]);
                }
            }
            String pathName = file.getParent()+"/"+newName;
            if (file.isDirectory() || (file.isFile() && !file.getName().contains("."))){
                while (new File(pathName).exists()){
                    pathName = pathName + " (1)";
                }
            }else {
                while (new File(pathName).exists()){
                    pathName = file.getParent() + "/" + newName.substring(0,newName.lastIndexOf('.'))
                            + " (1)" + newName.substring(newName.lastIndexOf('.'));
                }
            }
            if (file.renameTo(new File(pathName))){
                fileIndex++;
                log[fileIndex][0] = file.getPath();
                log[fileIndex][1] = pathName;
            }else{
                throw new Exception("Can not rename file: "+file.getPath());
            }
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void rollback() {
        if (log==null || this.log.length==0){
            return;
        }
        for (int i=log.length-1; i>=0; i--){
            if (new File(log[i][1]).renameTo(new File(log[i][0]))) {
                fileIndex--;
            }
        }
        log = null;
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void filesCounter(File dir) {
        totalFiles++;
        if (dir.getName().matches(regex)){
            filesToRename++;
        }
        if (dir.isDirectory()){
            File[] files = dir.listFiles();
            if (files != null) {
                if(files.length!=0) {
                    for (File eachFile : files) {
                        filesCounter(eachFile);
                    }
                }
            }
        }
    }

}
