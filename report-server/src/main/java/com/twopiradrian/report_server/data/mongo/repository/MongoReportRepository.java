package com.twopiradrian.report_server.data.mongo.repository;

import com.twopiradrian.report_server.data.mongo.model.ReportModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoReportRepository extends MongoRepository<ReportModel, String> {

}
