#### Program Name: IntegerInputVerifier
#### Programmer Name: Ali Rahbar
#### Program Date: January 25, 2023
#### Program Description: This program validates the integer input
#### Inputs: None
#### Outputs: None

---

### IPO Chart:


| **Method Name** | **Inputs** | **Outputs** | **Processes**                   |
|-----------------|------------|-------------|---------------------------------|
| verify          | input      | true/false  | This method validates the input |

### PseudoCode:

```text
Import required files

Create class IntegerVerifier extends InputVerifier
{
    In the verify method
    {
        Collect the input
        
        try
        {
            Save the inout in an integer
            
            return true
        }
        catch
        {
            Display error to page
            
            Return false
        }
    }
}
```


