package db2db;

import okio.Buffer;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface for opening all types of db relation files
 */
public interface DBFile extends Closeable, Flushable {
  /** Returns the Buffer for this DBFile */
  Buffer buffer();

  /** Uses fileLocation to create an InputStream that can be passed to Buffer */
  void setInputFile(String fileLocation) throws IOException;

  /** Uses fileLocation to create an OutputStream that can be passed to Buffer */
  void setOutputFile(String fileLocation) throws IOException;

  /** Scans directory of input file for related files such as TOAST tables */
  ArrayList<String> connectedFiles(String fileLocation) throws IOException;
}
