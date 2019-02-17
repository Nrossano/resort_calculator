import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResortCalc extends JFrame implements ItemListener
{
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	//Create 3 JCheckBox objects
	JCheckBox weekendbox = new JCheckBox("Weekend Premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastbox = new JCheckBox("Breakfast Premium $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfbox = new JCheckBox("Golf Premium $" + GOLF_PREMIUM, false);

	//Create 4 JLabels and 1 TextField object

	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel priceLabel = new JLabel("The price for your stay is");
	JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want.");
	JTextField total = new JTextField(4);

	//Constructor for the ResortCalc class
	public ResortCalc()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		add(weekendbox);
		add(breakfastbox);
		add(golfbox);
		add(resortLabel);
		add(priceLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(total);

		total.setText("$" + totalPrice);
		weekendbox.addItemListener(this);
		breakfastbox.addItemListener(this);
		golfbox.addItemListener(this);

	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		if(source == weekendbox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else
		{
			if(source == breakfastbox)
			{
				if(select == ItemEvent.SELECTED)
				{
				totalPrice += BREAKFAST_PREMIUM;
				}
			else
				{
				totalPrice -= BREAKFAST_PREMIUM;
				}
			}
			else //It must be (source == golfBox) by default
			{
				if(select == ItemEvent.SELECTED)
				{
					totalPrice += GOLF_PREMIUM;
				}
				else
				{
					totalPrice -= GOLF_PREMIUM;
				}
			}	
		}

		//After all the decision making, keep pushing the total price to the JTextField
		total.setText("$" + totalPrice);

	}

	public static void main(String[] args) {
		ResortCalc aFrame = new ResortCalc();
	}
}