# Assignment-weather-app


Hello, This assignment is based on a Registration form with validation like - <br />
  Register (* = mandatory):<br />
  Full Name *: 50 characters<br />
  Mobile *: Allow 10 digits only numbers<br />
  Gender = dropdown (male,female)<br />
  DOB * - with calender and date picker<br />
  Address *<br />
  Line 1 *: min 3 char , max 50 char<br />
  Line 2: 50 char<br />
  Pin code *: 6 numbers <br />
  District<br />
  State <br />
  District and State auto-populate based on Pincode<br />
  
    Used Library - 
   Retrofit - implementation 'com.squareup.retrofit2:retrofit:(insert latest version)'<br />
   Gson Converter - implementation 'com.squareup.retrofit2:converter-gson:latest.version'<br />
<br />
    
   Manifest Permission - Internet<br />
  
  
<br /><br />
<img src="https://user-images.githubusercontent.com/90592402/135382840-dbd773ee-8a1a-455c-b05a-3ed7404f10ef.png" width="200" height="400" /><br />
Screenshot link - https://user-images.githubusercontent.com/90592402/135382840-dbd773ee-8a1a-455c-b05a-3ed7404f10ef.png <br />

<br />
<br />
  Fields are required -<br />
  
  <img src="https://user-images.githubusercontent.com/90592402/135383102-85b86e05-5ffc-4dd1-83b2-870dec41789e.png" width="200" height="400" />
  Screenshot link - https://user-images.githubusercontent.com/90592402/135383102-85b86e05-5ffc-4dd1-83b2-870dec41789e.png <br />
  <img src="https://user-images.githubusercontent.com/90592402/135383277-cc7beb2e-5840-4532-a6d4-a8094327cca7.png" width="200" height="400" />
  Screenshot link - https://user-images.githubusercontent.com/90592402/135383277-cc7beb2e-5840-4532-a6d4-a8094327cca7.png <br />
  <br />
  <br />
  Dropdown menu -<br />
  
  <img src="https://user-images.githubusercontent.com/90592402/135383374-0952beff-e0c3-4855-890d-a2d8c020e051.png" width="200" height="400" />
  Screenshot link - https://user-images.githubusercontent.com/90592402/135383374-0952beff-e0c3-4855-890d-a2d8c020e051.png <br />
  <br />
<br />
  Calender and date picker -<br />
  
   <img src="https://user-images.githubusercontent.com/90592402/135383437-cd50428e-b903-4106-85ab-52f3759f56d5.png" width="200" height="400" />
   Screenshot link - https://user-images.githubusercontent.com/90592402/135383437-cd50428e-b903-4106-85ab-52f3759f56d5.png <br />
   <br />
<br />
   
   One Address field is important -<br />
   
   <img src="https://user-images.githubusercontent.com/90592402/135383576-09689f77-a6ce-4f71-afa9-4528a3e08753.png" width="200" height="400" />
   Screenshot link - https://user-images.githubusercontent.com/90592402/135383576-09689f77-a6ce-4f71-afa9-4528a3e08753.png <br />
   
   <br />
<br />
   Pincode check button is only active when user enter the Pincode -<br />
   
   <img src="https://user-images.githubusercontent.com/90592402/135383778-730b3111-99c2-44f5-b63d-f5524361fac0.png" width="200" height="400" /><br />
    Screenshot link -https://user-images.githubusercontent.com/90592402/135383778-730b3111-99c2-44f5-b63d-f5524361fac0.png <br />
   <img src="https://user-images.githubusercontent.com/90592402/135384154-b0985596-26a1-48b4-896c-cf8698c0fb20.png" width="200" height="400" /><br />
   Screenshot link - https://user-images.githubusercontent.com/90592402/135384154-b0985596-26a1-48b4-896c-cf8698c0fb20.png 
   
   <br />
<br />
   District and State auto populated when user enter the valid pincode -<br />
   
   <img src="https://user-images.githubusercontent.com/90592402/135384395-99ea5b1e-74a5-4a77-acdb-ceac6527cb40.png" width="200" height="400" /> 
   
    Screenshot link - https://user-images.githubusercontent.com/90592402/135384395-99ea5b1e-74a5-4a77-acdb-ceac6527cb40.png 
    
  
   When all required field are fill then user can able to register by clicking register button, it will show a message user registration success,
   and district information is captured from the registration screen, automatically filled to the weather widget screen.<br />
   
   
   <img src="https://user-images.githubusercontent.com/90592402/135385280-f0b34b8b-06b3-4392-b221-b48c170da987.png" width="200" height="400" />
     Screenshot link - https://user-images.githubusercontent.com/90592402/135385280-f0b34b8b-06b3-4392-b221-b48c170da987.png 
     

    Now, when user click on show result, all the information will be visible according to its, city name -
    
   <img src="https://user-images.githubusercontent.com/90592402/135385714-9d9e10ad-a08b-4822-9d1a-f9031b30440e.png" width="200" height="400" />
 Screenshot link - https://user-images.githubusercontent.com/90592402/135385714-9d9e10ad-a08b-4822-9d1a-f9031b30440e.png 
    

    Here, we  can also able to check any city information by typing it's city name -
   
