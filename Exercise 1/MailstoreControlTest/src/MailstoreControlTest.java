import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class MailstoreControlTest {

	@Test
	public void testMailstoreControlNoParametersGiven() {
		String actiualResult = MailstoreControl.mailstoreControl(null, null);
		String expectedMessage = GlobalConstants.INVALID_INPUT_MESSAGE;
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlNoActionParameterGiven() {
		String expectedMessage = GlobalConstants.INVALID_INPUT_MESSAGE;
		String actiualResult = MailstoreControl.mailstoreControl(null, "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlNoMailstoreParameterGiven() {
		String expectedMessage = GlobalConstants.INVALID_INPUT_MESSAGE;
		String actiualResult = MailstoreControl.mailstoreControl("mount", null);
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlInvalidActionGiven() {
		String expectedMessage = GlobalConstants.INVALID_ACTION_MESSAGE;
		String actiualResult = MailstoreControl.mailstoreControl("noAction", "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlInvalidMailstoreGiven() {
		String expectedMessage = GlobalConstants.INVALID_MAILSTORE_MESSAGE;
		String actiualResult = MailstoreControl.mailstoreControl("mount", "NoMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlUseMountActionOnMountedMailstore() {
		String expectedMessage = GlobalConstants.MOUNTED_MESSAGE;
		MailstoreControl.mailstoreControl("mount", "SampleMailstore");
		MailstoreControl.mailstoreControl("mount", "SampleMailstore");
		String actiualResult = MailstoreControl.mailstoreControl("check", "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlUseDismountActionOnMountedMailstore() {
		String expectedMessage = GlobalConstants.DISMOUNTED_MESSAGE;
		MailstoreControl.mailstoreControl("mount", "SampleMailstore");
		MailstoreControl.mailstoreControl("dismount", "SampleMailstore");
		String actiualResult = MailstoreControl.mailstoreControl("check", "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlUseMountActionOnDismountedMailstore() {
		String expectedMessage = GlobalConstants.MOUNTED_MESSAGE;
		MailstoreControl.mailstoreControl("dismount", "SampleMailstore");
		MailstoreControl.mailstoreControl("mount", "SampleMailstore");
		String actiualResult = MailstoreControl.mailstoreControl("check", "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
	
	@Test
	public void testMailstoreControlUseDismountActionOnDismountedMailstore() {
		String expectedMessage = GlobalConstants.DISMOUNTED_MESSAGE;
		MailstoreControl.mailstoreControl("dismount", "SampleMailstore");
		MailstoreControl.mailstoreControl("dismount", "SampleMailstore");
		String actiualResult = MailstoreControl.mailstoreControl("check", "SampleMailstore");
		
		assertEquals(expectedMessage, actiualResult);
	}
}
