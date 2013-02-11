package richservlet

import javax.servlet.http._

object ServletImplicits {
    
    implicit class RichHttpServletRequest(req: HttpServletRequest) {
 
        def getParameterOrElse(key: String, default: String): String = {
            getParameterOrElse(key, Some(default)).get
        }		  

        def getParameterOrNone(key: String): Option[String] = getParameterOrElse(key, None)
        			
        def getParameterOrElse(key: String, default: Option[String]): Option[String] = {
            val v = req.getParameter(key)
            if (v == null) default else Some(v)
		}	
    }
}