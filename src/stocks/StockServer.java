package stocks;

import java.security.InvalidParameterException;

public class StockServer {
	
	private int microsoftValue = 220;
	private int appleValue = 110;
	private int googleValue = 1512;
	
	public enum Stock {
		MICROSOFT,
		APPLE,
		GOOGLE
	}	
	
	public synchronized int GetStock(Stock stock) {
		switch(stock) {
		case MICROSOFT:
			return microsoftValue;
		case APPLE:
			return appleValue;
		case GOOGLE:
			return googleValue;
		default:
			throw new InvalidParameterException("no such stock type");
		}
	}
	public synchronized void UpdateStock(Stock stock, int value) {
		if (value < 100 || value > 500) {
			throw new InvalidParameterException("Stock value must be between 100 and 500");
		}

		switch (stock) {
			case MICROSOFT:
				microsoftValue = value;
				break;
			case APPLE:
				appleValue = value;
				break;
			case GOOGLE:
				googleValue = value;
				break;
			default:
				throw new InvalidParameterException("no such stock type");
		}
	}
}
