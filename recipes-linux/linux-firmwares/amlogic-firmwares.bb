SUMMARY = "Firmware files for Amlogic"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/amlogic-firmwares.tar.xz"

SRC_URI[md5sum] = "b38683a1dad38f3a07f74f9b509338f4"
SRC_URI[sha256sum] = "95a5ce5b6e979e291c62ccd5e773fc169f9782745f18475a7b06a2db20a0cba5"

S = "${WORKDIR}/amlogic-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/video
    install -m 0644 ${S}/*.bin ${D}${nonarch_base_libdir}/firmware/video/
}
