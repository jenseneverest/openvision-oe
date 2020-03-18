DESCRIPTION = "Open Vision version info"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Open Vision Developers"
require conf/license/license-gplv2.inc

inherit rm_python_pyc compile_python_pyo no_python_src

PV = "${VISIONVERSION}"
PR = "${VISIONREVISION}"

do_configure[nostamp] = "1"
do_install[nostamp] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://ov.py"

FILES_${PN} = "${sysconfdir} /usr"

BB_HASH_IGNORE_MISMATCH = "1"

S = "${WORKDIR}"

PACKAGES = "${PN}"

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
	echo "date=${DATETIME}" >> ${D}${sysconfdir}/image-version
	echo "comment=Open Vision" >> ${D}${sysconfdir}/image-version
	echo "target=9" >> ${D}${sysconfdir}/image-version
	echo "creator=Open Vision Developers" >> ${D}${sysconfdir}/image-version
	echo "url=https://openvision.tech" >> ${D}${sysconfdir}/image-version
	echo "catalog=https://github.com/OpenVisionE2" >> ${D}${sysconfdir}/image-version
	echo "distro=${DISTRO_NAME}" >> ${D}${sysconfdir}/image-version
	echo "arch=${DEFAULTTUNE}" >> ${D}${sysconfdir}/image-version
	echo "fpu=${TARGET_FPU}" >> ${D}${sysconfdir}/image-version
	echo "display-type=${DISPLAY_TYPE}" >> ${D}${sysconfdir}/image-version
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "1", "0", d)}" = "1" ]; then
		echo "small-flash=${HAVE_SMALLFLASH}" >> ${D}/etc/image-version
		echo "smallflash" > ${D}${sysconfdir}/smallflash
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "middleflash", "1", "0", d)}" = "1" ]; then
		echo "middle-flash=${HAVE_MIDDLEFLASH}" >> ${D}/etc/image-version
		echo "middleflash" > ${D}${sysconfdir}/middleflash
	fi
	echo "transcoding=${TRANSCODING}" >> ${D}${sysconfdir}/image-version
	echo "multitranscoding=${MULTITRANSCODING}" >> ${D}${sysconfdir}/image-version
	echo "multilib=${HAVE_MULTILIB}" >> ${D}${sysconfdir}/image-version
	echo "python3=${HAVE_PYTHON3}" >> ${D}${sysconfdir}/image-version
	echo "${MACHINE}" > ${D}${sysconfdir}/model
	echo "${BOX_BRAND}" > ${D}${sysconfdir}/brand
	echo "${VISIONVERSION}" > ${D}${sysconfdir}/visionversion
	echo "${VISIONREVISION}" > ${D}${sysconfdir}/visionrevision
	install -d ${D}${libdir}/python2.7
	install -m 0644 ${WORKDIR}/ov.pyo ${D}${libdir}/python2.7
}

pkg_postinst_ontarget_${PN} () {
touch /etc/enigma2/settings
if ! grep -qs "config.plugins.CacheFlush" cat /etc/enigma2/settings ; then
	echo "config.plugins.CacheFlush.free_default=2039" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timescrinfo=3" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.enable=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timeout=5" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.uncached=0" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.where=1" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.sync=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.scrinfo=false" >>/etc/enigma2/settings
fi
}

do_install[vardepsexclude] += "DATETIME"
