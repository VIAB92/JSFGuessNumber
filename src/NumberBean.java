import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by Виктор on 1/16/14.
 */
public class NumberBean {
    private Integer minValue;
    private Integer maxValue;
    private int currentNumber;
    private String userInput;

    public String setValues()
    {
        try
        {
            Random random = new Random();
            currentNumber = random.nextInt(maxValue.intValue()-minValue.intValue())+minValue.intValue();
            return "play";
        }
        catch (IllegalArgumentException ex)
        {
            return "error";
        }
    }

    public String checkInput()
    {
        if (userInput.toLowerCase().equals("bingo"))
        {
            return "success";
        }
        else
        {
            Random random = new Random();
            if (userInput.toLowerCase().equals("less"))
            {
                try
                {
                    maxValue = currentNumber;
                    currentNumber = random.nextInt(maxValue.intValue()-minValue.intValue())+minValue.intValue();
                    return null;
                }catch (IllegalArgumentException ex)
                {
                    return "error";
                }
            }
            else if (userInput.toLowerCase().equals("more"))
            {
                try
                {
                    minValue = currentNumber+1;
                    currentNumber = random.nextInt(maxValue.intValue()-minValue.intValue())+minValue.intValue();
                    return null;
                }catch (IllegalArgumentException ex)
                {
                    return "error";
                }
            }
            else
            {
                return "error";
            }
        }
    }

    public String playagain()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "playagain";
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
