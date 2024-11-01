# CSP-Header-Filter
Add custom CSP header filter to Tomcat.

# Usage
- Download jar from [here](https://github.com/onurilyastokay/CSP-Header-Filter/blob/main/target/CSPHeaderFilter.jar).
- Put CSPHeaderFilter.jar in your $CATALINA_HOME/lib directory.
- Add this configurations to your web.xml file:
```xml
<filter>
    <filter-name>CSPHeaderFilter</filter-name>
    <filter-class>com.onurilyastokay.CSPHeaderFilter</filter-class>
    <init-param>
        <param-name>contentSecurityPolicy</param-name>
        <param-value>
          <!-- ==================== Change With Your Content-Security-Policy Configuration ================= -->
            default-src 'self'; script-src 'self'; style-src 'self' 'unsafe-inline'; img-src 'self'; object-src 'none'; frame-ancestors 'self';
          <!-- ==================== Change With Your Content-Security-Policy Configuration ================= -->
        </param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CSPHeaderFilter</filter-name>
    <url-pattern>/*</url-pattern> 
</filter-mapping>
```
