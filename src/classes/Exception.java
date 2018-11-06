package classes;

@SuppressWarnings("serial")
class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String error_message) {
		super(error_message);
	}
}

@SuppressWarnings("serial")
class UserIsEmptyException extends Exception {
	public UserIsEmptyException(String error_message) {
		super(error_message);
	}
}

	@SuppressWarnings("serial")
	class UserNotFoundException extends Exception {
		public UserNotFoundException(String error_message) {
			super(error_message);
		}
}