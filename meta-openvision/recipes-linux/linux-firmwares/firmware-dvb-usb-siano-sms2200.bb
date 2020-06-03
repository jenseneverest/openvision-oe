LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/fw-isdbt_rio.tar.gz"

SRC_URI[md5sum] = "10a9c222faeaf1d44ad16c0f26bd2d8c"
SRC_URI[sha256sum] = "026b328092c76849da4ee0a732e7189f8e005a3c4aaecffc1e568a69f2ff73bd"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for dvb-usb-sms2200 isdbt_rio.inp"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 isdbt_rio.inp ${D}${nonarch_base_libdir}/firmware
}
