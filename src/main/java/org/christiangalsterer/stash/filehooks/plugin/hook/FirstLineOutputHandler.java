package org.christiangalsterer.stash.filehooks.plugin.hook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.atlassian.bitbucket.scm.CommandOutputHandler; 
 
/**
 * Returns the first line of output provided by the git process. 
 */ 
public class FirstLineOutputHandler extends LineReaderOutputHandler implements 
        CommandOutputHandler<String> { 
 
    private String sha; 
 
    FirstLineOutputHandler() {
        super(StandardCharsets.UTF_8);
    } 
 
    @Nullable 
    @Override 
    public String getOutput() { 
        return sha; 
    } 
 
    @Override 
    protected void processReader(LineReader lineReader) throws IOException { 
        sha = lineReader.readLine(); 
 
        // ignore the rest of the output 
        String nextLine = lineReader.readLine(); 
        while (nextLine != null) { 
            nextLine = lineReader.readLine(); 
        } 
    } 
 
}