package com.mediga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

public class FileProcessing {
    public static void main(String[] args) {
        File file = new File(args[0]);
        File[] files = file.listFiles();
        DataProcessor dataProcessor = new DataProcessor();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService<FileProcessResult> completionService = new ExecutorCompletionService<>(executorService);
        for(File f : files) {
            completionService.submit(new Task(f, dataProcessor));
        }

        List<FileProcessResult> fileProcessResults = new ArrayList<>();
        Future<FileProcessResult> result;
        try{
            while((result = completionService.take()) != null) {
                fileProcessResults.add(result.get());
            }
        } catch (Exception e) {

        }

        Collections.sort(fileProcessResults, (f1, f2) -> (int) (f2.getTimeTaken() - f1.getTimeTaken()));
    }
}

class Task implements Callable<FileProcessResult> {
    File file;
    DataProcessor dataProcessor;

    public Task(File file, DataProcessor dataProcessor) {
        this.file = file;
        this.dataProcessor = dataProcessor;
    }

    @Override
    public FileProcessResult call() throws Exception {
        Map<Boolean, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int count = 0;
        while((line = reader.readLine()) != null) {
            count++;
            boolean result = dataProcessor.parse(line);
            Integer c = map.get(result);
            if(c == null) {
                c = 1;
            } else {
                c++;
            }
            map.put(result, c);
        }

        FileProcessResult fileProcessResult = new FileProcessResult();
        fileProcessResult.setFile(file);
        fileProcessResult.setMap(map);
        fileProcessResult.setTimeTaken(count);
        return fileProcessResult;
    }
}

class FileProcessResult {
    File file;
    Map<Boolean, Integer> map;
    long timeTaken;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map<Boolean, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Boolean, Integer> map) {
        this.map = map;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
