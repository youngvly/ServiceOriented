package koreatech.cse.thread;

import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.repository.WorknetMapper;
import koreatech.cse.service.news.NaverNewsGet;
import koreatech.cse.service.worknet.WorknetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

public class TimerAutoJob implements Runnable {
    @Inject
    private WorknetService worknetService;
    @Inject
    private NaverNewsGet naverNewsGet;
    @Inject
    private WorknetMapper worknetMapper;

    WorkNetItem workNetItem = null;

    // XML 태그를 가져 올 수 있는 함수
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    // 오늘 날짜를 출력하는 함수
    private String getDate() {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return String.valueOf(simpleDateFormat.format(d));
    }

    @Override
    public void run() {
        try {
            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            String workNetURL = "http://openapi.work.go.kr/opi/opi/opia/dhsOpenEmpInfoAPI.do?authKey=WNJOZFA0SUBQIQ9WUQ6MH2VR1HJ&callTp=L&returnType=XML&startPage=1&display=100";
            Document doc = dBuilder.parse(workNetURL);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("dhsOpenEmpInfo");
            System.out.println("리스트 수 " + nList.getLength());
            // 리스트에 담긴 데이터 출력
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    if (Objects.equals(getTagValue("empWantedStdt", element), getDate())) {
                        workNetItem = new WorkNetItem();
                        workNetItem.setEmpWantedTitle(getTagValue("empWantedTitle", element));
                        workNetItem.setEmpBusiNm(getTagValue("empBusiNm", element));
                        workNetItem.setCoClcdNm(getTagValue("coClcdNm", element));
                        workNetItem.setEmpWantedStdt(getTagValue("empWantedStdt", element));
                        workNetItem.setEmpWantedEndt(getTagValue("empWantedEndt", element));
                        workNetItem.setEmpWantedTypeNm(getTagValue("empWantedTypeNm", element));
                        workNetItem.setRegLogImgNm(getTagValue("regLogImgNm", element));
                        workNetItem.setEmpWantedHomepgDetail(getTagValue("empWantedHomepgDetail", element));
                        worknetService.insertWork(workNetItem);

                        /*
                        System.out.println("#############################################");
                        System.out.println("제목 : " + getTagValue("empWantedTitle", element));
                        System.out.println("채용업체 : " + getTagValue("empBusiNm", element));
                        System.out.println("기업구분 : " + getTagValue("coClcdNm", element));
                        System.out.println("채용시작일 : " + getTagValue("empWantedStdt", element));
                        System.out.println("채용종료일 : " + getTagValue("empWantedEndt", element));
                        System.out.println("고용형태 : " + getTagValue("empWantedTypeNm", element));
                        System.out.println("채용기업로고 : " + getTagValue("regLogImgNm", element));
                        System.out.println("채용기업사이트 : " + getTagValue("empWantedHomepgDetail", element));
                        */
                    }
                }
            }

            List<Job> jobList = worknetMapper.selectAllJobName();
            System.out.println(jobList);
            for(Job j : jobList){
                naverNewsGet.getNewsByQuery(j.getName());
            }

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){

        }
    }
}
