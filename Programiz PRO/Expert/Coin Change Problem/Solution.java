import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int coinChange(int total, List<Integer> coins) {
        int number = -1;
        		int counter = 0;
                		ArrayList<Integer> remainder = new ArrayList<Integer>();
                        		ArrayList<Integer> remainderCoins = new ArrayList<Integer>();
                                		String value = "";
                                        		for(int index = coins.size()-1;index >= 0;index--)
                                                		{
                                                        			int coin = coins.get(index);
                                                                    			if(coin != 1)
                                                                                			{
                                                                                            				remainderCoins.add(coin);
                                                                                                            				remainder.add(total % coin);
                                                                                                                            			}
                                                                                                                                        		}
                                                                                                                                                		for(int modulus = 0; modulus < total;modulus ++)
                                                                                                                                                        		{
                                                                                                                                                                			ArrayList<Integer> indices = getIndices(remainder,modulus);
                                                                                                                                                                            			if(indices.size() == 0)
                                                                                                                                                                                        				continue;
                                                                                                                                                                                                        			ArrayList<Integer> current = getCurrentCoins(remainderCoins,indices);
                                                                                                                                                                                                                    			for(int index = current.size()-1;index >= 0;index --)
                                                                                                                                                                                                                                			{
                                                                                                                                                                                                                                            				int coin = current.get(index);
                                                                                                                                                                                                                                                            				int count = total / coin;
                                                                                                                                                                                                                                                                            				counter += count;
                                                                                                                                                                                                                                                                                            				total = total - (count * coin);
                                                                                                                                                                                                                                                                                                            				value += count + " - " + coin + " coins\n";
                                                                                                                                                                                                                                                                                                                            				if(total == 0)
                                                                                                                                                                                                                                                                                                                                            				{
                                                                                                                                                                                                                                                                                                                                                            					number = counter;
                                                                                                                                                                                                                                                                                                                                                                                					break;
                                                                                                                                                                                                                                                                                                                                                                                                    				}
                                                                                                                                                                                                                                                                                                                                                                                                                    			}
                                                                                                                                                                                                                                                                                                                                                                                                                                		}
                                                                                                                                                                                                                                                                                                                                                                                                                                        		if(coins.contains(1))
                                                                                                                                                                                                                                                                                                                                                                                                                                                			number = counter + total;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            		return number;
    }
    public static ArrayList<Integer> getIndices(ArrayList<Integer> list,int key)
    	{
        		ArrayList<Integer> indices = new ArrayList<Integer>();
                		for(int index = 0; index < list.size();index ++)
                        			if(list.get(index) == key)
                                    				indices.add(index);
                                                    		return indices;
                                                            	}
                                                                	public static ArrayList<Integer> getCurrentCoins(ArrayList<Integer> list,ArrayList<Integer> indices)
                                                                    	{
                                                                        		ArrayList<Integer> coins = new ArrayList<Integer>();
                                                                                		for(int index = 0;index < indices.size();index ++)
                                                                                        			coins.add(list.get(indices.get(index)));
                                                                                                    		Collections.sort(coins);
                                                                                                            		return coins;
                                                                                                                    	}

}