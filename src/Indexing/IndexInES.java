package Indexing;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import static org.elasticsearch.node.NodeBuilder.*;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

public class IndexInES {

	public IndexInES(String ES_server,String ES_port,String ES_index,String json)
	{
		System.out.println(json);
		System.out.println("ES "+ES_server+ES_port+ES_index);
		//Node node = nodeBuilder().local(true).node();
		Client client = new TransportClient()
        .addTransportAddress(new InetSocketTransportAddress(ES_server, Integer.valueOf(ES_port)));
		
		//CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate("logs1");
	   // CreateIndexResponse response = createIndexRequestBuilder.execute().actionGet();
	   // System.out.println(response.isAcknowledged());  
		IndexResponse response1 = client.prepareIndex(ES_index, "log")
		        .setSource(json)
		        .execute()
		        .actionGet();
		//node.close();
		client.close();
	}
}
