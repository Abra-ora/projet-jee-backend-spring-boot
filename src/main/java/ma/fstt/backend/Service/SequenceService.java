package ma.fstt.backend.Service;

import ma.fstt.backend.Model.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.management.Query;

import java.io.ObjectInputStream;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String seq_name){
        DbSequence conter = mongoOperations.findAndModify(query(where("_id").is(seq_name)),new Update().inc("seq",1),options().returnNew(true).upsert(true),DbSequence.class );
    return !Objects.isNull(conter) ? conter.getSeq() : 1;
    }

}
