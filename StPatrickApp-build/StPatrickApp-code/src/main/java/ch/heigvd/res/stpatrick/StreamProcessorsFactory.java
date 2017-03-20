package ch.heigvd.res.stpatrick;

import java.io.Reader;
import java.io.Writer;

/**
 * This class is responsible for providing different types of Stream Processors.
 * 
 * @author Olivier Liechti
 */
public class StreamProcessorsFactory implements IStreamProcessorsFactory, IStreamDecoratorController {

  @Override
  public IStreamProcessor getProcessor() {
    return new BasicStreamProcessor();
  }

  @Override
  public IStreamProcessor getProcessor(String processorName) throws UnknownNameException {
    if(processorName.endsWith("-remover")){
       return new RemoverProcessor(processorName.charAt(0));
    }
    throw new UnknownNameException("The factory does not know any processor called " + processorName);
  }

   @Override
   public Reader decorateReader(Reader inputReader) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Writer decorateWriter(Writer outputWriter) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
