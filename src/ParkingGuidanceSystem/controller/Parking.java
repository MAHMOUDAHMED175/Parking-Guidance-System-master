package ParkingGuidanceSystem.controller;

import java.util.List;

// interface دا علشان يحدد  الخصائص المشتركه بين ال objects وبعضها مثال لدينا كلاس للفواكه يوجد به موز وتفاح وهما قابلين للاكل وكلاس للحيوانات فيه الدجاج والاسود فهنا الدجاج قابل للاكل ولالاسود  لا فهنا يود خصائص مشتركه وهيا قابليه الاكل لكل من الموز والتفاح والالدجاج
public interface Parking {
    
    public List ViewSpots();
    
}
