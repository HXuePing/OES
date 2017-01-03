package com.oes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import com.oes.pojo.ExamTimer;

@Controller
@RequestMapping("/student")
public class TimerData {
	private static long h=0;
	private static long m=0;
	private static long s=0;
	
	// long show;
	// public static long show;
	/*public TimerData(long aa){
		this.show=aa;
	
	}*/
	public   void settime(int aaa){
		
        int min=aaa;
        long start=System.currentTimeMillis();
        
        final long end=start+min*60*1000;
        
         final Timer timer=new Timer();
      
        
        timer.schedule(new TimerTask()
        {
        	  public   void run()
              {
                
        		  long show=end-System.currentTimeMillis();
                  h=show/1000/60/60;
                  m=show/1000/60%60;
                  s=show/1000%60;
                  System.out.println(""+h+""+m+""+s);
                  show=show-1000;
              }
          
        },0,1000);
     
        timer.schedule(new TimerTask()
        {
            public synchronized  void run()
            {
                timer.cancel();
            }
            
        }, new Date(end));
		
      
		
	}
	
	
	@RequestMapping(value="/getTimedemo",method=RequestMethod.POST)
	public void gettime(HttpServletResponse response,HttpServletRequest request) throws IOException{				        
       /* List<ExamTimer> list=new ArrayList<ExamTimer>();
        list.add(et);  */    
			
		/*String time=request.getParameter("time");		
		 h=show/1000/60/60;
         m=show/1000/60%60;
         s=show/1000%60;
         show=show-Long.parseLong(time);  */
        
        ExamTimer et=new ExamTimer();
 		et.setH(h);
 		et.setM(m);
 		et.setS(s);
        Gson gson=new Gson();
        String json=gson.toJson(et);
       
       
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf8");
		PrintWriter w=response.getWriter();
		w.write(json);	
	}
}
