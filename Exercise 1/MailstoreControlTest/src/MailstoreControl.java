public class MailstoreControl {

	public static Mailstore[] mailstores = {
			new Mailstore("SampleMailstore", false),
			new Mailstore("LocalMailstore", true),
			new Mailstore("GlobalMailstore", false), };

	public static void main(String[] args) {

	}

	public static String mailstoreControl(String action, String mailstoreName) {
		if (action == null || mailstoreName == null) {
			return GlobalConstants.INVALID_INPUT_MESSAGE;
		}

		if (action != "mount" && action != "dismount" && action != "check") {
			return GlobalConstants.INVALID_ACTION_MESSAGE;
		}

		Mailstore selectedMailstore = getMailstoreByName(mailstores,
				mailstoreName);

		if (selectedMailstore == null) {
			return GlobalConstants.INVALID_MAILSTORE_MESSAGE;
		}

		if (action.equals("mount")) {

			selectedMailstore.setMounted(true);
			return GlobalConstants.MOUNTED_MESSAGE;

		} else if (action.equals("dismount")) {

			selectedMailstore.setMounted(false);
			return GlobalConstants.DISMOUNTED_MESSAGE;

		} else if (action.equals("check")) {

			return selectedMailstore.isMounted() ? GlobalConstants.MOUNTED_MESSAGE
					: GlobalConstants.DISMOUNTED_MESSAGE;

		} else {
			return GlobalConstants.INVALID_ACTION_MESSAGE;
		}
	}

	private static Mailstore getMailstoreByName(Mailstore[] mailstores,
			String mailstoreName) {

		for (int i = 0; i < mailstores.length; i++) {
			if (mailstores[i].getName().equals(mailstoreName)) {
				return mailstores[i];
			}
		}

		return null;
	}
}
