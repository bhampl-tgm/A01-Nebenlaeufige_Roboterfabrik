package au01;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;
import tgm.sew.hit.roboterfabrik.util.csv.ExtendedRAF;

public class TestExtendedRAF {

	@Test
	public void testRAF() throws IOException {
		ExtendedRAF eraf = new ExtendedRAF(new File("test.test"), "rw");
		eraf.readLastLine();
		eraf.deleteLastLine();
	}
}
