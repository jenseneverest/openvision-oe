DESCRIPTION = "Open Vision version info"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Open Vision Developers"
require conf/license/license-gplv2.inc

PV = "${VISIONVERSION}-${VISIONREVISION}"
PR = "${DATETIME}"

PR[vardepsxeclude] = "DATETIME"

INSANE_SKIP_${PN} += "file-rdeps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://settings \
           file://ov.py \
          "

FILES_${PN} = "${sysconfdir} /usr"

BB_HASH_IGNORE_MISMATCH = "1"

S = "${WORKDIR}"

PACKAGES = "${PN}"

do_compile() {
	python -O -m compileall ${S}
}

do_install() {
	install -d ${D}${sysconfdir}
	echo "STB=${MACHINE}" > ${D}${sysconfdir}/image-version
	echo "Brand=${BOX_BRAND}" > ${D}${sysconfdir}/image-version
	echo "box_type=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "build_type=0" >> ${D}${sysconfdir}/image-version
	echo "machine_brand=${BOX_BRAND}" >> ${D}${sysconfdir}/image-version
	echo "machine_name=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "version=${VISIONVERSION}-${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "build=${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "Python=2.7" >> ${D}${sysconfdir}/image-version
	echo "date=${PR}" >> ${D}${sysconfdir}/image-version
	echo "comment=Open Vision" >> ${D}${sysconfdir}/image-version
	echo "target=9" >> ${D}${sysconfdir}/image-version
	echo "creator=Open Vision Developers" >> ${D}${sysconfdir}/image-version
	echo "url=https://openvision.tech" >> ${D}${sysconfdir}/image-version
	echo "catalog=https://github.com/OpenVisionE2" >> ${D}${sysconfdir}/image-version
	echo "distro=${DISTRO_NAME}" >> ${D}${sysconfdir}/image-version
	echo "transcoding=${TRANSCODING}" >> ${D}${sysconfdir}/image-version
	echo "multitranscoding=${MULTITRANSCODING}" >> ${D}${sysconfdir}/image-version
	echo "display-type=${DISPLAY_TYPE}" >> ${D}${sysconfdir}/image-version
	echo "flash-type=${HAVE_SMALLFLASH}" >> ${D}/etc/image-version
	echo "${MACHINE}" > ${D}${sysconfdir}/model
	echo "${BOX_BRAND}" > ${D}${sysconfdir}/brand
	echo "${VISIONVERSION}" > ${D}${sysconfdir}/visionversion
	echo "${VISIONREVISION}" > ${D}${sysconfdir}/visionrevision
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "1", "0", d)}" = "1" ]; then
		echo "smallflash" > ${D}${sysconfdir}/smallflash
	fi
	install -d ${D}${sysconfdir}/enigma2
	install -m 0755 ${WORKDIR}/settings ${D}${sysconfdir}/enigma2
	install -d ${D}${libdir}/python2.7
	install -m 0644 ${WORKDIR}/ov.pyo ${D}${libdir}/python2.7
}
