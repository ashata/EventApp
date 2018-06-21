# EventApp
I wrote this Progressive web app for our wedding and deployed on cloud platform Digital Ocean at that time. 

It reads data/content from mongo to display dynamic data and has pages/abilities like 
    
    Home
  
    Directions

    Gift Registry(list of all places, url redirect only and not fully integrated like a Knot registry import)

    RSVP for guests

    spring boot security enabled RSVP report/guest viewer for admin to login and filter/browse at real time.

    Wedding program
    
    This can be extended to have guest list and any other pages by adding/reusing ui templates 
    and a simple spring boot JPA as needed. 

As the groom, Charlie Mehrer worked on cleaning up css and enhancing UI

RSVP form is implemented with angular schema form library: http://schemaform.io/

I used Google PWA https://developers.google.com/web/fundamentals/codelabs/your-first-pwapp/ and integrated that concept into a Spring boot app and wrote the UI in angular instead of the javascript used in the codelab


Why PWA: One of the cool features is, it asks user for permission to save a widget/bookmark on the phone. 

When saved, it looks and works just like a native app on the phone but is really just 1 responsive website. 

It helps you consolidate your web and mobile app developers to avoid cost and maintenance. 

Create a simple, single, seamless web/responsive application that runs on all devices

and supports cool features like offline data, push notifications and look/feel of a native app.

One of my favorite PWA to try on your phone: https://paperplanes.world/
