SUMMARY = "Firmware files for RPi"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-firmwares.tar.xz"

SRC_URI[md5sum] = "15269a73ef045f5e540f729c694c7b55"
SRC_URI[sha256sum] = "ebb945c8c25366950aa755cd97b554a0c6974e2910da871c7d50404420793fc0"

S = "${WORKDIR}/rpi-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S}/* ${D}${nonarch_base_libdir}/firmware/
}
