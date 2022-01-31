# Selenium_TestNG_Allure_Report

## Prerequisite
1. Need to install jdk 8 or 11 or any LTS version
2. Set up Java Home & Gradle Home
3. Download Allure latest version & configure allure to the environment path

## How to Run the Project
1. Clone the repository
2. Run cmd in the root folder
3. Then give the following command in cmd

  ```
  gradle clean test
  ```
  ```
  allure generate allure-results --clean -o allure-report
  ```
  ```
  allure serve allure-results
  ```
  
  ## Screenshots of the Allure Report
  
![Allure_Report_Screenshot_1](https://user-images.githubusercontent.com/96170694/151860945-9246ee38-f8ea-47b4-a250-673c65eb4b8a.JPG)
![Allure_Report_Screenshot_2](https://user-images.githubusercontent.com/96170694/151860952-b5985d33-ca45-42fb-a22f-9cd41f342561.JPG)
