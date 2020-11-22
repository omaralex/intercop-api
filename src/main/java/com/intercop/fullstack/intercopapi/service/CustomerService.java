package com.intercop.fullstack.intercopapi.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.intercop.fullstack.intercopapi.pojo.Customer;
import com.intercop.fullstack.intercopapi.pojo.ResponseGet;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    public static final String COL_NAME="customers";

    public String saveCustomer(Customer customer) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(customer.getName()).set(customer);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public ResponseGet getAverageStandardDeviation() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        int agesSum = documents.stream()
                .map(ob ->(ob.toObject(Customer.class).getAge()))
                .reduce(0, Integer::sum);

        Double average = Double.valueOf(agesSum/documents.size());
        Double variance = 0.0;

        for (QueryDocumentSnapshot document : documents) {
            Double range;
            range = Math.pow(document.toObject(Customer.class).getAge() - average, 2f);
            variance = variance + range;
        }

        variance = variance/documents.size();
        Double standardDeviation = Math.sqrt(variance);

        ResponseGet responseGet = new ResponseGet(average,standardDeviation);
        return responseGet;
    }

    public List<Customer> getAllCustomers() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Customer> customersList = documents.stream()
                .map(ob ->(ob.toObject(Customer.class))).collect(Collectors.toList());
        return customersList;
    }

}