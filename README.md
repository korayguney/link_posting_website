# link-posting-website
I wrote code of a simple link posting web site using with JSP patterns. Users will be able to post links and others will be able to browse them.
> ----- Business Rules -----
>   * Web site must look similar through all of the pages, having same headers and footers. The application starts with [APPLICATION ADDRESS]/home page.
>
>      /// Home Page
>    * Display “Home” and “Register” menu items (User has not logged in)
>    * Display Login form
>        + Display error on wrong username-password
>        + After successful login:
>           § Display Home page.
>           § Write “Welcome [USERNAME]” at the top of the page (all pages)
>           § Display “Home”, “My Links”, “Post Link”, “Logout” menu items.
>    * When “Logout” clicked, log the user out, switch menu items and remove welcome message.
>    * Display all links posted to the application
>        + Details: Link title, link address, post date, number of views and username
>    * Display Search functionality.
>        + When a keyword is entered and “Search” button clicked, filter the links according to the search criteria.
>        + When “Reset” is clicked, display all the links posted.
>    * When a link is clicked, increase the view count and redirect the user to the link address
>    * When a username is clicked, display the links of the user. On the page, display “[USERNAME] Links” text as header.
>
>      //// User Registeration
>    * Provide username and password to login
>    * If username exists inform the user
>    * Upon successful login, inform the user that they must login.
>
>      //// My Links
>    * Only logged in users can access. If otherwise, display home page.
>    * Display logged in user’s links (Title, link address, post date, views).
>    * Users can delete their links, page is refreshed after delete.
>
>      //// Post Link 
>    * Only logged in users can access. If otherwise, display home page.
>    * Link title and Link address must be entered by the user
>    * Post date the is insertion date
>    * Username-link address are primary keys together on the database, thus a user cannot post the same link twice, inform the user if they try otherwise.
>    * Upon submit, display My Links page
