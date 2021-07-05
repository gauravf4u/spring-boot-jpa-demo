package com.example.demo.controller;

import com.example.demo.MatterData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/matter-search")
public class MatterSearchController {

  @GetMapping("/list")
  public List<MatterData> getRecords() {
    MatterData data1 = new MatterData("my first patent application","patentApplication1","AA-123","United States","unfiled");
    MatterData data2 = new MatterData("my second patent application","patentApplication2","AA-124","United States","pending");
    List<MatterData> matterDataList = new ArrayList<>(Arrays.asList(data1, data2));
    return matterDataList;
  }
}
