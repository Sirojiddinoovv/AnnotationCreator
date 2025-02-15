package uz.nodir.beanregisterdemo.service.client;


/**
 * @author: PC
 * @date: 15.02.2025
 * @group: DavrCoders
 **/
public interface ClientService {

    /**
     * Mock generated service for describe how to work unique request annotation
     */

    void send(String requestId, String message);

    void send(Long requestId, String message);
}
