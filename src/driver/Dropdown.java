package driver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
		public static void main(String[] args) {
			FirefoxDriver driver=new FirefoxDriver();
			driver.get("file://C:/Users/Pallabi/Desktop/w.html");
		    String expVal = "mava";
			boolean flag=false;
			WebElement wb=driver.findElement(By.name("sel"));
			Select sel=new Select(wb);
			List<WebElement> lst=sel.getOptions();
			System.out.println(lst.size());
			for(WebElement wbOption : lst)
			{
				String actval=wbOption.getText();
				if(expVal.equals(actval))
				{
					sel.selectByVisibleText(expVal);
					System.out.println(expVal+"==>option is available==PASS");
	flag=true;
	break;
				}
			}
			if(flag==false)
			{
				System.out.println(expVal+"==>option is not available==FAIL");
				}	
		}
	}

