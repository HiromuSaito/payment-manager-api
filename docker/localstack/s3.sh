#!/bin/bash
echo "Init localstack s3"
BUCKET_NAME=payment-manager-qr-bucket
awslocal s3 mb s3://${BUCKET_NAME}

