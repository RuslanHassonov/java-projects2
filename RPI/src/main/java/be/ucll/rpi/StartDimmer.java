package be.ucll.rpi;

import static com.pi4j.io.i2c.I2CBus.BUS_1;
import static org.apache.commons.lang3.ArrayUtils.reverse;

import java.math.BigDecimal;
import java.net.DatagramSocket;

import org.apache.commons.lang3.ArrayUtils;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

public class StartDimmer {

	/**
	 * TODO SET THE VALUE TO THE NUMBER IN YOUR PI USERNAME. IF THIS IS "PI1", SET THIS TO "1". IF IT IS "PI2", SET IT TO "2" etc
	 * (this value is added to the base number of '5000' to ensure everyone uses his/her unique port)
	 */
	private static final int REPLACE_VALUE_WITH_YOUR_NUMBER = -1;

	public static void main(String[] args) throws Exception {
		I2CBus bus = I2CFactory.getInstance(BUS_1);
		I2CDevice i2CDeviceOne = bus.getDevice(0x59);

		DatagramSocket serverSocket = new DatagramSocket(5000 + REPLACE_VALUE_WITH_YOUR_NUMBER);
		byte[] receiveData = new byte[4];
		System.out.println("STARTED");

		while (true) {

			/**
			 * TODO RECEIVE FROM UDP HERE
			 * Use the already created 'serverSocket' to receive the values a in the already created 4 bytes array 'receiveData'. This array will thus receive the 4
			 * bytes being sent by the frontend representing the color to be shown for the led strip (R G B each 1 byte) and the intensity of the downlight (4th btye)
			 */

			for (int i = 0; i < 4; i++) {
				BigDecimal b = new BigDecimal(Byte.toUnsignedInt(receiveData[i]));
				System.err.println(b);
				byte[] toSend = convert(b);
				reverse(toSend);
				toSend = ArrayUtils.insert(0, toSend, (byte) i);
				i2CDeviceOne.write(toSend, 0, toSend.length);
				Thread.sleep(100);
			}
		}
	}

	private static byte[] convert(BigDecimal bigDecimal) {
		byte[] b = new BigDecimal(1023).divide(new BigDecimal(255), 2, BigDecimal.ROUND_HALF_UP).multiply(bigDecimal).toBigInteger().toByteArray();
		if (b.length == 1) {
			b = new byte[] { 0, b[0] };
		}
		return b;
	}
}
