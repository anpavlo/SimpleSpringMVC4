package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FacebookService;
import social.FacebookFriends;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Controller
public class StartController {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("friendsList", facebookService.getAllFriends());
        return "startPage";
    }

    @RequestMapping(value = "/friendsXML", method = RequestMethod.GET)
    @ResponseBody
    public FacebookFriends getXML() {
        return new FacebookFriends(facebookService.getAllFriends());
    }

    @RequestMapping(value = "/friendsXHTML", method = RequestMethod.GET)
    public void getXTML(HttpServletResponse response) {
        FacebookFriends result = new FacebookFriends(facebookService.getAllFriends());
        response.setContentType("text/xml; charset=UTF-8");
        Writer writer;
        try {
            writer = response.getWriter();
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<?xml-stylesheet type=\"text/xsl\" href=\"resources\\templates\\friendsTable.xsl\"?>");
            JAXBContext context = JAXBContext.newInstance(FacebookFriends.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(result, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/friendsXHTMLServer", method = RequestMethod.GET)
    public void getXTMLServer(HttpServletResponse response) {
        FacebookFriends result = new FacebookFriends(facebookService.getAllFriends());
        response.setContentType("text/html; charset=UTF-8");
        try {
            TransformerFactory transformerfactory =
                    TransformerFactory.newInstance();
            Transformer transformer = transformerfactory.newTransformer(
                    new StreamSource(servletContext.getResourceAsStream("/resources/templates/friendsTable.xsl")));

            JAXBContext context = JAXBContext.newInstance(FacebookFriends.class);

            transformer.transform(new JAXBSource(context, result), new StreamResult(response.getWriter()));
        } catch (JAXBException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "sayhello";
    }

}
