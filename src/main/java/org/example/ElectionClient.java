package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.ElectionProto.ElectionData;
import org.example.ElectionProto.Party;
import org.example.ElectionProto.ElectionDataRequest;
import org.example.ElectionProto.ElectionDataResponse;

public class ElectionClient {

    private final ElectionServiceGrpc.ElectionServiceBlockingStub blockingStub;

    public ElectionClient(ManagedChannel channel) {
        this.blockingStub = ElectionServiceGrpc.newBlockingStub(channel);
    }

    private ElectionData createElectionData() {
        ElectionData.Builder dataBuilder = ElectionData.newBuilder();

        dataBuilder.setRegionID("33123")
                .setRegionName("Linz Bahnhof")
                .setRegionAddress("Bahnhofsstrasse 27/9")
                .setRegionPostalCode("4020")
                .setFederalState("Austria")
                .setTimestamp("2024-09-12 11:48:21");

        dataBuilder.addCountingData(
                Party.newBuilder().setPartyID("OEVP").setAmountVotes(322).build()
        );
        dataBuilder.addCountingData(
                Party.newBuilder().setPartyID("SPOE").setAmountVotes(301).build()
        );
        dataBuilder.addCountingData(
                Party.newBuilder().setPartyID("FPOE").setAmountVotes(231).build()
        );
        dataBuilder.addCountingData(
                Party.newBuilder().setPartyID("GRUENE").setAmountVotes(211).build()
        );
        dataBuilder.addCountingData(
                Party.newBuilder().setPartyID("NEOS").setAmountVotes(182).build()
        );

        return dataBuilder.build();
    }

    public void sendElectionData() {
        ElectionData data = createElectionData();
        ElectionDataRequest request = ElectionDataRequest.newBuilder()
                .setData(data)
                .build();

        ElectionDataResponse response = blockingStub.transferElectionData(request);
        System.out.println("Response from server: " + response.getMessage());
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ElectionClient client = new ElectionClient(channel);
        client.sendElectionData();

        channel.shutdown();
    }
}
