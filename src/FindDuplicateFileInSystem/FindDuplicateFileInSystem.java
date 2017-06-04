package FindDuplicateFileInSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System
 *
 * Given a list of directory info including directory path,
 * and all the files with contents in this directory,
 * you need to find out all the groups of duplicate files in the file system in terms of their paths.
 *
 * A group of duplicate files consists of at least two files that have exactly the same content.
 * A single directory info string in the input list has the following format:
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 *
 * It means there are n files
 * (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively)
 * in directory root/d1/d2/.../dm.
 *
 * Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 *
 * The output is a list of group of duplicate file paths. For each group,
 * it contains all the file paths of the files that have the same content.
 *
 * A file path is a string that has the following format:
 * "directory_path/file_name.txt"
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];
            for (int i=1; i<parts.length; i++) {
                String filename = parts[i].substring(0, parts[i].indexOf("("));
                String content = parts[i].substring(parts[i].indexOf("(")+1, parts[i].indexOf(")"));
                if (!map.containsKey(content)) {
                    map.put(content, new LinkedList<>());
                }
                map.get(content).add(directory+"/"+filename);
            }
        }

        List<List<String>> result = new LinkedList<>();
        for (String content: map.keySet()) {
            if (map.get(content).size() > 1) {
                result.add(map.get(content));
            }
        }
        return result;
    }
}
