package wsb.merito.pz.cw10.nio_tutorial.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public interface FileChannelExample {

    public static enum FileOperation {
	READ, WRITE;
    }

    default FileChannel createChannel(String path, FileOperation fileOperation) throws FileNotFoundException {
	//final File file = new File(FileChannelReadExample.class.getClassLoader().getResource(path).getFile());
        final File file = new File(path);
        return fileOperation == FileOperation.READ ? new FileInputStream(file).getChannel() : new FileOutputStream(file).getChannel();
    }
}
