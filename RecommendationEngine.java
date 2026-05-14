package com.codtech.AIRecommendationSystem;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecommendationEngine {

	public static void recommendProducts(long userId) {

	    try {

	        DataModel model =
	                new FileDataModel(new File("ratings.csv"));

	        UserSimilarity similarity =
	                new PearsonCorrelationSimilarity(model);

	        UserNeighborhood neighborhood =
	                new NearestNUserNeighborhood(3, similarity, model);
	        
	        GenericUserBasedRecommender recommender =
	                new GenericUserBasedRecommender(
	                        model,
	                        neighborhood,
	                        similarity);

	        List<RecommendedItem> recommendations =
	                recommender.recommend(userId, 5);

	        Map<Long, Product> products =
	                ProductStore.getProducts();

	        System.out.println("\nRecommended Products:\n");

	        if (recommendations.isEmpty()) {

	            System.out.println(
	                    "No recommendations found for this user.");

	        } else {

	            for (RecommendedItem item : recommendations) {

	                Product product =
	                        products.get(item.getItemID());

	                if (product != null) {

	                    System.out.println(
	                            "Product: "
	                                    + product.getProductName());

	                    System.out.println(
	                            "Price: ₹"
	                                    + product.getPrice());

	                    System.out.println(
	                            "Predicted Rating: "
	                                    + item.getValue());

	                    System.out.println(
	                            "----------------------");
	                }
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
