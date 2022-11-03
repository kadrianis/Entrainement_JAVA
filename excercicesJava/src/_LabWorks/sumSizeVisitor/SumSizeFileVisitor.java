package sumSizeVisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

//import jdk.internal.org.jline.terminal.Size;

public class SumSizeFileVisitor implements FileVisitor<Path> {

	AtomicLong taille = new AtomicLong(); //

	public SumSizeFileVisitor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("preVisiteDirectory : " + dir);

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("visitFile : " + file);
		System.out.println("La taille de " + file + " est :   " + Files.size(file));
		if (Files.isRegularFile(file)) {// on verifier si file est un fichier regulier

			//System.out.println(file + " est regulier");
			taille.addAndGet(attrs.size());// on prend la taille de attrs est en la stoque dans la variable taille et on
											// incrémente a chaque passage dans un fichier
		}
		// System.out.println(size);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("visitFileFailed : " + file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("postVisitDirectory: " + dir);
		return FileVisitResult.CONTINUE;
	}

}
