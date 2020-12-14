import os
import json
import urllib
from urllib.request import urlopen

DDRAGON_CDN_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/"
IMAGE_DOWNLOAD_BASE_PATH = "./"

def getLatestVersion():
    version_url = "https://ddragon.leagueoflegends.com/api/versions.json"
    text_data = urllib.request.urlopen(version_url).read().decode("utf-8")
    version_json_data = json.loads(text_data)
    return version_json_data[0]


def crawlChampionImages(latest_version):
    champion_json_request_url = DDRAGON_CDN_BASE_URL + latest_version + "/data/en_US/champion.json"
    champion_image_request_base_url = DDRAGON_CDN_BASE_URL + latest_version + "/img/champion/"
    text_data = urllib.request.urlopen(champion_json_request_url).read().decode("utf-8")
    champion_json_data = json.loads(text_data)

    champions = champion_json_data["data"]
    for champion_name in champions.keys():
        champion = champions[champion_name]
        image_download_path = IMAGE_DOWNLOAD_BASE_PATH + "champion/" + str(champion["key"]) + ".png"

        if not os.path.isfile(image_download_path):
            champion_image_request_url = champion_image_request_base_url + champion["id"] + ".png"
            print("Downloading from " + champion_image_request_url)
            with urlopen(champion_image_request_url) as res:
                res_data = res.read()

                with open(image_download_path, 'wb') as f:
                    f.write(res_data)


def crawlItemImages(latest_version):
    item_json_requestl_url = DDRAGON_CDN_BASE_URL + latest_version + "/data/en_US/item.json"
    item_image_request_base_url = DDRAGON_CDN_BASE_URL + latest_version + "/img/item/"
    text_data = urllib.request.urlopen(item_json_requestl_url).read().decode("utf-8")
    
    item_json_data = json.loads(text_data)
    for item_number in item_json_data["data"].keys():
        image_download_path = IMAGE_DOWNLOAD_BASE_PATH + "item/" + item_number + ".png"
        if not os.path.isfile(image_download_path):
            item_image_request_url = item_image_request_base_url + item_number + ".png"
            print("Downloading from " + item_image_request_url)
            with urlopen(item_image_request_url) as res:
                res_data = res.read()

                with open(image_download_path, 'wb') as f:
                    f.write(res_data)


def crawlProfileIconImages(latest_version):
    profile_icon_json_request_url = DDRAGON_CDN_BASE_URL + latest_version + "/data/en_US/profileicon.json"
    profile_icon_image_request_base_url = DDRAGON_CDN_BASE_URL + latest_version + "/img/profileicon/"
    text_data = urllib.request.urlopen(profile_icon_json_request_url).read().decode("utf-8")

    profile_icon_json_data = json.loads(text_data)
    for profile_icon_number in profile_icon_json_data["data"].keys():
        image_download_path = IMAGE_DOWNLOAD_BASE_PATH + "profileicon/" + profile_icon_number + ".png"
        if not os.path.isfile(image_download_path):
            profile_icon_image_request_url = profile_icon_image_request_base_url + profile_icon_number + ".png"
            print("Downloading from " + profile_icon_image_request_url)
            with urlopen(profile_icon_image_request_url) as res:
                res_data = res.read()

                with open(image_download_path, "wb") as f:
                    f.write(res_data)

def main():
    latest_version = getLatestVersion()
    crawlChampionImages(latest_version)
    crawlItemImages(latest_version)
    crawlProfileIconImages(latest_version)


if __name__ == '__main__':
    main()