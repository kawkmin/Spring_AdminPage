package com.example.adminpage.ifs;

import com.example.adminpage.moel.network.Header;

public interface CrudInterface {

    Header create();
    Header read(Long id);
    Header update();
    Header delete(Long id);
}
