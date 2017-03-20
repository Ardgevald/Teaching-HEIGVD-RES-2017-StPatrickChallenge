
package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 */
public class RemoverProcessor implements IStreamProcessor{
   char charToRemove;

   public RemoverProcessor(char c) {
      this.charToRemove = c;
   }
   
  public void process(Reader in, Writer out) throws IOException {
    BufferedReader br = new BufferedReader(in);
    BufferedWriter bw = new BufferedWriter(out);
    
    int c = br.read();
    while (c != -1) {
      writeC(c, bw);
      c = br.read();
    }
    bw.flush();
  }
  
  void writeC(int c, BufferedWriter bw) throws IOException{
     if((char)c != Character.toLowerCase(charToRemove) && (char)c != Character.toUpperCase(charToRemove) ){
        bw.write(c);
     }
  }
}
